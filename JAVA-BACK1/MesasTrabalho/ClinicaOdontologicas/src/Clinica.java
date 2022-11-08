import java.sql.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Clinica {
    private static final Logger logger = Logger.getLogger(Clinica.class);
    public static final String sqlCreateBDClinica = "DROP schema IF EXISTS clinica;" +
            "CREATE schema IF NOT EXISTS clinica;"; //Criar BD

    public static final String sqlCreateTableEndreço = "CREATE TABLE IF NOT EXISTS endereço" +
            "(id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, Rua VARCHAR(50), Numero INT , Cidade VARCHAR(50)," +
            "Bairro VARCHAR(50) );";
    //Criar TABLE ENDEREÇO

    public static final String sqlCreateTablePaciente = "CREATE TABLE IF NOT EXISTS paciente " +
            "(ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY, IdEndereço INT NOT NULL  ,Nome VARCHAR (50) NOT NULL, " +
            "Sobrenome VARCHAR(50) NOT NULL," +
            "RG VARCHAR(30) NOT NULL, Data DATE);";
    // CRIAR TABLE PACIENTE

    public static final String sqlAddFKpaciente = "ALTER TABLE paciente ADD FOREIGN KEY(IdEndereço)" +
            "REFERENCES endereço(id);";
    // CRIAR FK PACIENTE E ENDEREÇO


    public static final String sqlInsertEndereço = "INSERT INTO endereço (Rua, Numero, Cidade, Bairro)" +
            "VALUES(?,?,?,?);";
    // Inserir na tabale endereço

    public static final String sqlInsertPaciente = "INSERT INTO paciente (IdEndereço, Nome, Sobrenome," +
            "RG, Data) VALUES (?,?,?,?,?);";
    // Inserir Cliente

    public static final String sqlConsultar = "SELECT * FROM paciente WHERE ID = ?;";
    // Consultar cliente com ID

    public static final String sqlConsultarEndereço = "SELECT * FROM endereço WHERE id = ?;";

    public static void main(String[] args) throws Exception {
        logger.info("Começamos nosso consulta");

        Endereço endereço = new Endereço("A",2,"Salvador","Cajazeiras");
        Endereço endereço2 = new Endereço("B",3,"Salvador","Cajazeiras");
        Endereço endereço3 = new Endereço("C",4,"Salvador","Cajazeiras");
        //Endereço endereço4 = new Endereço("C",4,"Salvador","Cajazeiras");


        Paciente paciente = new Paciente("José","Sousa","2238223345","1998-02-23",endereço);
        Paciente paciente2 = new Paciente("Maria","Sousa","2238223345","1998-02-23",endereço2);
        Paciente paciente3 = new Paciente("Joao","sousa","233223232","1998-02-10",endereço3);
       // Paciente paciente4 = new Paciente("Joao","sousa","233223232","1998-02-10",endereço4);


        Connection connection = null;

        try {
            connection = Conexão.getConnection();

            connection.setAutoCommit(false); // Desabilitar o autoCommit para termos o controle de quando realizar


            Statement statement = connection.createStatement();
            statement.execute(sqlCreateBDClinica); //Executa a Query


            statement.execute(sqlCreateTableEndreço); //Executa a Query

            statement.execute(sqlCreateTablePaciente); //Executa a Query

            statement.execute(sqlAddFKpaciente);//Executa a Query



            PreparedStatement preparedStatementEndereço = connection.prepareStatement(sqlInsertEndereço);
            preparedStatementEndereço.setString(1,endereço.getRua());
            preparedStatementEndereço.setInt(2,endereço.getNumero());
            preparedStatementEndereço.setString(3,endereço.getCidade());
            preparedStatementEndereço.setString(4,endereço.getBairro());
            preparedStatementEndereço.executeUpdate();
            //Insere o endereço no bando de dados
            //O set... precisa respeitar o tipo String,Int de acordo com oq vai ser passado
            //parametroIndex é a ordem das interrogações da Query q está sendo passada


            PreparedStatement preparedStatementPaciente = connection.prepareStatement(sqlInsertPaciente);
            preparedStatementPaciente.setInt(1,endereço.getId());
            preparedStatementPaciente.setString(2,paciente.getNome());
            preparedStatementPaciente.setString(3,paciente.getSobreNome());
            preparedStatementPaciente.setString(4,paciente.getRg());
            preparedStatementPaciente.setString(5,paciente.getData());
            preparedStatementPaciente.executeUpdate();


            PreparedStatement preparedStatementConsultar = connection.prepareStatement(sqlConsultar);
            preparedStatementConsultar.setInt(1,paciente.getId());


           ResultSet consultar = preparedStatementConsultar.executeQuery();
            while (consultar.next()){
                System.out.println("ID IDendereço Nome Sobre Nome     RG");
              System.out.println(consultar.getInt(1)+"      "
            +consultar.getString(2)+"      "+consultar.getString(3)+"    "
              +consultar.getString(4)+"    "
              +consultar.getString(5));
            }

            PreparedStatement preparedStatementConsultarEndereço = connection.prepareStatement(sqlConsultarEndereço);
            preparedStatementConsultarEndereço.setInt(1,endereço.getId());

            ResultSet consultarEndereço = preparedStatementConsultarEndereço.executeQuery();
            while (consultarEndereço.next()){
                System.out.println("Endereço:");
                System.out.println("ID: "+consultarEndereço.getInt(1)
                +" Rua: "+consultarEndereço.getString(2)+
                        " Numero: "+consultarEndereço.getString(3)+" "
                +" Cidade: "+consultarEndereço.getString(4)+" "+
                        " Bairro: "+ consultarEndereço.getString(5));
            }










            logger.info("Consulta finalizada");

            connection.commit(); //realizarar todas as auterações desde o ultimo commit
            connection.setAutoCommit(true); // boa pratica, de voltar o autoCommit como padrão true

        }catch (Exception e){
            logger.error("ERROR NA EXECUÇÃO");
            e.printStackTrace();
            connection.rollback();
        }



    }
}
