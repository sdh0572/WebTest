package phonebook;

import java.util.List;

public interface PhonebookInter {
//설계역할
	public int insert(Phonebook pb);
	public List<Phonebook> selectAll();
	public Phonebook selectById(int id);
	public int update(Phonebook pb);
	public int delete(int id);
	public List<Phonebook> search(String s);
}
