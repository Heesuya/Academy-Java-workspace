package kr.co.iei.point.vo;

public class SearchResult {
	private String type;
	private int searchIndex;

	public SearchResult() {
		super();
	}
	
	public SearchResult(String type, int searchIndex) {
		super();
		this.type = type;
		this.searchIndex = searchIndex;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public int getSearchIndex() {
		return searchIndex;
	}
	public void setSearchIndex(int searchIndex) {
		this.searchIndex = searchIndex;
	}
	
	
}
