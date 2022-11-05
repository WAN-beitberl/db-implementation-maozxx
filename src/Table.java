import java.util.*;

public class Table
{
    Columns columns;
    List<Row> rows;

    Table(){
        rows = new LinkedList<Row>();
        columns = new Columns();
    }

    class Columns{
        int numberOfColumns ;
        Map<String,Integer> columnNames;

        Columns(){
            numberOfColumns = 0;
            columnNames = new HashMap<>();
        }
        public void add(String columnName) {
            columnNames.put(columnName,numberOfColumns);
            numberOfColumns++;
        }

        public int getColumnIndex(String name){
            return columnNames.get(name);
        }
    }

    class Row{
        String[] fields;

        public Row(String[] fields) {
            this.fields = fields;
        }

        public String getField(int columnNumber) {
            return fields[columnNumber];
        }
    }

    void insertColumNames(String... columnsNamesList)
    {
        for (String column : columnsNamesList) {
            columns.add(column);
        }
    }

    void insertRow(String... fields )
    {
        rows.add(new Row(fields));
    }

    String getValue(String name, int number)
    {
        int columnNumber = columns.getColumnIndex(name);
        return rows.get(number).getField(columnNumber);
    }


}