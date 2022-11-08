import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;

//Material de estudo

import java.sql.*;


public class Main {
    public static void main(String[] args) throws Exception {


        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName).getDeclaredConstructor().newInstance();

        String host = "localhost";
        String dbName ="status_carregamento";
        String url = "jdbc:mysql://" + host + "/" + dbName;
        String username = "root";        //nome de um usuário de seu BD
        String password = "";      //sua senha de acessotry {

        Connection connection = DriverManager.getConnection(url,username,password);

try {
            connection.setAutoCommit(false); // Desabilitar o autoCommit para termos o controle de quando realizar


            Statement statement = connection.createStatement();//vai enviar as querys para o meu banco de dados



        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS animal " +
                "(ID INT PRIMARY KEY, Nome VARCHAR (50) NOT NULL, TIPO VARCHAR(50) NOT NULL);";


       // statement.execute(sqlCreateTable);

       // String consultar = "SELECT * FROM processos;";
    //ResultSet rs = statement.executeQuery(consultar);
                        // Consulta com statement, não passa paramentros!


          String consultar = "SELECT * FROM processos WHERE status_carregamento = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(consultar);
        preparedStatement.setString(1,"Carregado");
        ResultSet rs = preparedStatement.executeQuery();
                        //consulta com preparedStatment, passa parametros



    while (rs.next()){
            System.out.println(rs.getInt(1)+
                    " "+ rs.getInt(2)+
                    " "+ rs.getString(4)
                   );
        }







        connection.commit(); //realizarar todas as auterações desde o ultimo commit
        connection.setAutoCommit(true); // boa pratica, de voltar o autoCommit como padrão true

}catch (Exception e){
        connection.rollback(); // sempre usar rollback para em caso de erro, voltar para informação do ultimo commit!
}
    }


}

// Exemplo insert
// String query = ("INSERT INTO Person (Name, Nickname) VALUES (?, ?)”);
//
//try (
// PreparedStatement preparedStatement = con.prepareStatement(query)) {
//
//   preparedStatement.setString(1, "José");
//   preparedStatement.setString(2, "Zé");
//   preparedStatement.executeUpdate();
//
//}
//catch (SQLException ex) {
//} //

//exemplo delete
//try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
//
//   preparedStatement.setString(1, "Zé");
//   preparedStatement.executeUpdate();
//
//}
//catch (SQLException ex) {
//} //
//para Delete e Insert é usado executeUpdate() e NÃO executeQuery!



//Exemplo Update
//String query = ("UPDATE Person SET Name = ? WHERE Nickname = ?”);
//
//try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
//
//   preparedStatement.setString(1, "José");
//   preparedStatement.setString(2, "Zé");
//   preparedStatement.executeUpdate();
//
//}
//catch (SQLException ex) {
//}  //