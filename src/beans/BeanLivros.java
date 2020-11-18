package beans;

public class BeanLivros {
	
	private String nome;
	private String autor;
	private String status;
	private String id;
	private String emprestimo;
	
	public BeanLivros(){
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(String emprestimo) {
		this.emprestimo = emprestimo;
	}
	
}
