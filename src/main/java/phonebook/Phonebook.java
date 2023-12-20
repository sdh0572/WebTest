package phonebook;

public class Phonebook {
	int id;
	String name;
	String hp;
	String memo;
	
	public Phonebook() {
		// TODO Auto-generated constructor stub
	}
	public Phonebook(int id, String name, String hp, String memo) {
		super();
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.memo = memo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "Phonebook [id=" + id + ", name=" + name + ", hp=" + hp + ", memo=" + memo + "]";
	}
	
}
