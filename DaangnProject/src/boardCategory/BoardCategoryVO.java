package boardCategory;

public class BoardCategoryVO {

	private String categoryId;
	private String categoryName;
	
	public BoardCategoryVO() {
		super();
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "BoardCategoryVO [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
}
