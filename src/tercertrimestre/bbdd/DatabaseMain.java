package tercertrimestre.bbdd;

import java.sql.SQLException;

public class DatabaseMain
{
    public static void main(String[] args)
    {
        try
        {
            ConnectionManager connectionManager = new ConnectionManager();
        }
        catch (SQLException sqlException)
        {
            System.err.printf("ERROR: Error al operar con la BD: %s", sqlException);
        }
    }
}
