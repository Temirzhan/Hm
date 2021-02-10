public class Main {
    public static void main(String[] args) {
      String primaryLoad = "CREATE TABLE if not exists Cat(StudID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Name TEXT NOT NULL, Health INTEGER NOT NULL, Damage INTEGER NOT NULL, Satiety BOOLEAN NOT NULL);";

        Cat cat = new Cat("kiti",100,100);
        Cat cat2 = new Cat("kiti2",100,100);
        Cat cat3 = new Cat("kiti3",100,100);
        NewSql catSql = new NewSql(primaryLoad);
        catSql.newConect();
        catSql.updateSql(cat);
        catSql.updateSql(cat2);
        catSql.updateSql(cat3);
        catSql.getSql();
        catSql.printSql();
    }
}
