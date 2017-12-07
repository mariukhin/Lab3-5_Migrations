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

        File change_create_tables = new File(ClassLoader.getSystemResource("changelog/deleteAllTable/db.changelog-0.0.0.xml").getFile());
        File change_set_data = new File(ClassLoader.getSystemResource("liquibase/3.0-set-data.xml").getFile());
        File change_set_row = new File(ClassLoader.getSystemResource("liquibase/3.1-set-row.xml").getFile());
        File change_update_row = new File(ClassLoader.getSystemResource("liquibase/3.2-update-row.xml").getFile());
        File change_join = new File(ClassLoader.getSystemResource("liquibase/3.3-query-join.xml").getFile());
        File change_rename = new File(ClassLoader.getSystemResource("liquibase/5.0-rename-column.xml").getFile());
        File change_new_column = new File(ClassLoader.getSystemResource("liquibase/5.1-new-column.xml").getFile());
        File change_new_table = new File(ClassLoader.getSystemResource("liquibase/5.2-new-table.xml").getFile());
        File change_delete_row = new File(ClassLoader.getSystemResource("liquibase/4.1-delete-row.xml").getFile());
        File change_delete_rows = new File(ClassLoader.getSystemResource("liquibase/4.0-delete-all-rows.xml").getFile());
        File change_drop_tables = new File(ClassLoader.getSystemResource("liquibase/2.0-drop-tables.xml").getFile());

        Liquibase create_tables = new liquibase.Liquibase(change_create_tables.toString(), new FileSystemResourceAccessor(), database);
        Liquibase set_data = new liquibase.Liquibase(change_set_data.toString(), new FileSystemResourceAccessor(), database);
        Liquibase set_row = new liquibase.Liquibase(change_set_row.toString(), new FileSystemResourceAccessor(), database);
        Liquibase update_row = new liquibase.Liquibase(change_update_row.toString(), new FileSystemResourceAccessor(), database);
        Liquibase query_join = new liquibase.Liquibase(change_join.toString(), new FileSystemResourceAccessor(), database);
        Liquibase rename_column = new liquibase.Liquibase(change_rename.toString(), new FileSystemResourceAccessor(), database);
        Liquibase new_column = new liquibase.Liquibase(change_new_column.toString(), new FileSystemResourceAccessor(), database);
        Liquibase new_table = new liquibase.Liquibase(change_new_table.toString(), new FileSystemResourceAccessor(), database);
        Liquibase delete_row = new liquibase.Liquibase(change_delete_row.toString(), new FileSystemResourceAccessor(), database);
        Liquibase delete_all_rows = new liquibase.Liquibase(change_delete_rows.toString(), new FileSystemResourceAccessor(), database);
        Liquibase drop_tables = new liquibase.Liquibase(change_drop_tables.toString(), new FileSystemResourceAccessor(), database);

        create_tables.update(new Contexts(), new LabelExpression());
/*        set_data.update(new Contexts(), new LabelExpression());
        set_row.update(new Contexts(), new LabelExpression());
        set_row.update(new Contexts(), new LabelExpression());
        update_row.update(new Contexts(), new LabelExpression());
        query_join.update(new Contexts(), new LabelExpression());
        rename_column.update(new Contexts(), new LabelExpression());
        new_column.update(new Contexts(), new LabelExpression());
        new_table.update(new Contexts(), new LabelExpression());
        delete_row.update(new Contexts(), new LabelExpression());
        delete_all_rows.update(new Contexts(), new LabelExpression());
        drop_tables.update(new Contexts(), new LabelExpression());*/

    }
}
