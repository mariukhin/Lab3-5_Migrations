import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Connect.connect();
        try {
            testMigrations();
            System.out.println("All migrations successful...");
        } catch (LiquibaseException ex) {
            ex.printStackTrace();
        }
        Connect.disconnect();
    }

    public static void testMigrations() throws LiquibaseException {

        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));

/*
        File change_droptableFirst = new File(ClassLoader.getSystemResource("changelog/dropTableWithoutSaving/db.changelog-1.7.1.xml").getFile());
        File change_droptableSecond = new File(ClassLoader.getSystemResource("changelog/dropTableWithoutSaving/db.changelog-1.7.2.xml").getFile());
        File change_droptableThird = new File(ClassLoader.getSystemResource("changelog/dropTableWithoutSaving/db.changelog-1.7.3.xml").getFile());
        File change_droptableFourth = new File(ClassLoader.getSystemResource("changelog/dropTableWithoutSaving/db.changelog-1.7.4.xml").getFile());
        File change_droptableFifth = new File(ClassLoader.getSystemResource("changelog/dropTableWithoutSaving/db.changelog-1.7.5.xml").getFile());
*/

        File change_create_tableFirst = new File(ClassLoader.getSystemResource("changelog/create/db.changelog-1.0.1.xml").getFile());
        File change_create_tableSecond = new File(ClassLoader.getSystemResource("changelog/create/db.changelog-1.0.2.xml").getFile());
        File change_create_tableThird = new File(ClassLoader.getSystemResource("changelog/create/db.changelog-1.0.3.xml").getFile());
        File change_create_tableFourth = new File(ClassLoader.getSystemResource("changelog/create/db.changelog-1.0.4.xml").getFile());
        File change_create_tableFifth = new File(ClassLoader.getSystemResource("changelog/create/db.changelog-1.0.5.xml").getFile());

        File lab5_insert_tableFirst = new File(ClassLoader.getSystemResource("lab5/insertData/db.changelog-5.1.xml").getFile());
        File lab5_insert_tableSecond = new File(ClassLoader.getSystemResource("lab5/insertData/db.changelog-5.2.xml").getFile());

        File lab5_select = new File(ClassLoader.getSystemResource("lab5/selectData/db.changelog-5.1.1.xml").getFile());

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*File change_insert_tableFirst = new File(ClassLoader.getSystemResource("changelog/insert/db.changelog-1.1.1.xml").getFile());
        File change_insert_tableSecond = new File(ClassLoader.getSystemResource("changelog/insert/db.changelog-1.1.2.xml").getFile());
        File change_insert_tableThird = new File(ClassLoader.getSystemResource("changelog/insert/db.changelog-1.1.3.xml").getFile());
        File change_insert_tableFourth = new File(ClassLoader.getSystemResource("changelog/insert/db.changelog-1.1.4.xml").getFile());
        File change_insert_tableFifth = new File(ClassLoader.getSystemResource("changelog/insert/db.changelog-1.1.5.xml").getFile());

        File change_setRaw = new File(ClassLoader.getSystemResource("changelog/setRaw/db.changelog-1.2.3.xml").getFile());
        File change_update_table = new File(ClassLoader.getSystemResource("changelog/updateTable/db.changelog-1.5.5.xml").getFile());
        File change_join = new File(ClassLoader.getSystemResource("changelog/join/db.changelog-2.1.2.xml").getFile());
        File change_rename_column = new File(ClassLoader.getSystemResource("changelog/renameColumn/db.changelog-1.3.5.xml").getFile());
        File change_new_column = new File(ClassLoader.getSystemResource("changelog/deleteColumn/db.changelog-1.2.5.1.xml").getFile());
        File change_new_table = new File(ClassLoader.getSystemResource("changelog/dropTable/db.changelog-1.4.5.1.xml").getFile());
        File change_delete_row = new File(ClassLoader.getSystemResource("changelog/deleteRow/db.changelog-1.6.5.xml").getFile());
        File change_deleteAllrows = new File(ClassLoader.getSystemResource("changelog/deleteAllraws/db.changelog-1.3.8.xml").getFile());*/
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
        Liquibase drop_tableFirst = new liquibase.Liquibase(change_droptableFirst.toString(), new FileSystemResourceAccessor(), database);
        Liquibase drop_tableSecond = new liquibase.Liquibase(change_droptableSecond.toString(), new FileSystemResourceAccessor(), database);
        Liquibase drop_tableThird = new liquibase.Liquibase(change_droptableThird.toString(), new FileSystemResourceAccessor(), database);
        Liquibase drop_tableFourth = new liquibase.Liquibase(change_droptableFourth.toString(), new FileSystemResourceAccessor(), database);
        Liquibase drop_tableFifth = new liquibase.Liquibase(change_droptableFifth.toString(), new FileSystemResourceAccessor(), database);
*/

        Liquibase create_tableFirst = new liquibase.Liquibase(change_create_tableFirst.toString(), new FileSystemResourceAccessor(), database);
        Liquibase create_tableSecond = new liquibase.Liquibase(change_create_tableSecond.toString(), new FileSystemResourceAccessor(), database);
        Liquibase create_tableThird = new liquibase.Liquibase(change_create_tableThird.toString(), new FileSystemResourceAccessor(), database);
        Liquibase create_tableFourth = new liquibase.Liquibase(change_create_tableFourth.toString(), new FileSystemResourceAccessor(), database);
        Liquibase create_tableFifth = new liquibase.Liquibase(change_create_tableFifth.toString(), new FileSystemResourceAccessor(), database);

        Liquibase insert_tableFirst = new liquibase.Liquibase(lab5_insert_tableFirst.toString(), new FileSystemResourceAccessor(), database);
        Liquibase insert_tableSecond = new liquibase.Liquibase(lab5_insert_tableSecond.toString(), new FileSystemResourceAccessor(), database);

        Liquibase select1 = new liquibase.Liquibase(lab5_select.toString(), new FileSystemResourceAccessor(), database);
        /*Liquibase insert_tableFirst = new liquibase.Liquibase(change_insert_tableFirst.toString(), new FileSystemResourceAccessor(), database);
        Liquibase insert_tableSecond = new liquibase.Liquibase(change_insert_tableSecond.toString(), new FileSystemResourceAccessor(), database);
        Liquibase insert_tableThird = new liquibase.Liquibase(change_insert_tableThird.toString(), new FileSystemResourceAccessor(), database);
        Liquibase insert_tableFourth = new liquibase.Liquibase(change_insert_tableFourth.toString(), new FileSystemResourceAccessor(), database);
        Liquibase insert_tableFifth = new liquibase.Liquibase(change_insert_tableFifth.toString(), new FileSystemResourceAccessor(), database);


        Liquibase set_raw = new liquibase.Liquibase(change_setRaw.toString(), new FileSystemResourceAccessor(), database);
        Liquibase update_table = new liquibase.Liquibase(change_update_table.toString(), new FileSystemResourceAccessor(), database);
        Liquibase full_join = new liquibase.Liquibase(change_join.toString(), new FileSystemResourceAccessor(), database);
        Liquibase rename_column = new liquibase.Liquibase(change_rename_column.toString(), new FileSystemResourceAccessor(), database);
        Liquibase new_column = new liquibase.Liquibase(change_new_column.toString(), new FileSystemResourceAccessor(), database);
        Liquibase new_table = new liquibase.Liquibase(change_new_table.toString(), new FileSystemResourceAccessor(), database);
        Liquibase delete_row = new liquibase.Liquibase(change_delete_row.toString(), new FileSystemResourceAccessor(), database);
        Liquibase delete_all_rows = new liquibase.Liquibase(change_deleteAllrows.toString(), new FileSystemResourceAccessor(), database);*/

/*
        drop_tableFirst.update(new Contexts(), new LabelExpression());
        drop_tableSecond.update(new Contexts(), new LabelExpression());
        drop_tableThird.update(new Contexts(), new LabelExpression());
        drop_tableFourth.update(new Contexts(), new LabelExpression());
        drop_tableFifth.update(new Contexts(), new LabelExpression());
*/

        create_tableFirst.update(new Contexts(), new LabelExpression());
        create_tableSecond.update(new Contexts(), new LabelExpression());
        create_tableThird.update(new Contexts(), new LabelExpression());
        create_tableFourth.update(new Contexts(), new LabelExpression());
        create_tableFifth.update(new Contexts(), new LabelExpression());

        insert_tableFirst.update(new Contexts(), new LabelExpression());
        insert_tableSecond.update(new Contexts(), new LabelExpression());
        select1.update(new Contexts(), new LabelExpression());

        /*insert_tableFirst.update(new Contexts(), new LabelExpression());
        insert_tableSecond.update(new Contexts(), new LabelExpression());
        insert_tableThird.update(new Contexts(), new LabelExpression());
        insert_tableFourth.update(new Contexts(), new LabelExpression());
        insert_tableFifth.update(new Contexts(), new LabelExpression());

        set_raw.update(new Contexts(), new LabelExpression());
        update_table.update(new Contexts(), new LabelExpression());
        full_join.update(new Contexts(), new LabelExpression());
        rename_column.update(new Contexts(), new LabelExpression());
        new_column.update(new Contexts(), new LabelExpression());
        new_table.update(new Contexts(), new LabelExpression());
        delete_row.update(new Contexts(), new LabelExpression());
        delete_all_rows.update(new Contexts(), new LabelExpression());*/

    }
}
