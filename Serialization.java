import java.io.*;
public class Serialization {
	public static void main(String[] args){
		File path = new File("dot.txt");
		User usr = new User("Yusif","Ibrahimov",19,5);
		//Serialization.writeObjectToFile(usr,path);
		User usr2 = (User)readByDeserialization(path);
		System.out.println(usr2);


	}

	public static void writeObjectToFile(Object obj,File path){
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))){
			out.writeObject(obj);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static Object readByDeserialization(File path){
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))){
			Object obj = in.readObject();
			return obj;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}
class User implements Serializable{
	private String name;
	private String surname;
	private int age;
	private transient int id;
	public User(String name,String surname,int age,int id){
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.id = id;
	}
	@Override
	public String toString(){
		return this.name+"  "+this.surname+"  "+this.age+"  "+this.id;
	}
}