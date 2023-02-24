package board.vo;

	
import java.util.Date;

	public class BoardVO {

		private int boardId; // 게시글ID
		private String memId; // 회원ID
		private String categoryId; // 카테고리분류ID
		private String boardTitle; // 게시글제목
		private String boardContents; // 게시글내용
		private int price; // 가격
		private Date regiTime; // 등록시간
		private Date updateTime; // 업데이트시간
		private String regRange; // 지역범위
		private int intCnt; // 관심개수
		private int chatCnt; //채팅수
		private int views; // 조회수
		private int boardStatus; // 판매현황
		private String hopeLatitude; //희망위치 위도
		private String hopeLongitude; //희망위치 경도
		private String keyword; // 검색 키워드
		private String fileStreCours; // 저장파일경로
		private int fileSn = 1;       // 파일순번
		
		private int start; // 페이지에 표시될 게시글의 start
		private int end; // 페이지에 표시될 게시글의 end

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public BoardVO() {
			super();
		}

		public int getBoardId() {
			return boardId;
		}

		public void setBoardId(int boardId) {
			this.boardId = boardId;
		}

		public String getMemId() {
			return memId;
		}

		public void setMemId(String memId) {
			this.memId = memId;
		}

		public String getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(String categoryId) {
			this.categoryId = categoryId;
		}

		public String getBoardTitle() {
			return boardTitle;
		}

		public void setBoardTitle(String boardTitle) {
			this.boardTitle = boardTitle;
		}

		public String getBoardContents() {
			return boardContents;
		}

		public void setBoardContents(String boardContents) {
			this.boardContents = boardContents;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public Date getRegiTime() {
			return regiTime;
		}

		public void setRegiTime(Date regiTime) {
			this.regiTime = regiTime;
		}

		public Date getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}

		public String getRegRange() {
			return regRange;
		}

		public void setRegRange(String regRange) {
			this.regRange = regRange;
		}

		public int getIntCnt() {
			return intCnt;
		}

		public void setIntCnt(int intCnt) {
			this.intCnt = intCnt;
		}

		public int getChatCnt() {
			return chatCnt;
		}

		public void setChatCnt(int chatCnt) {
			this.chatCnt = chatCnt;
		}

		public int getViews() {
			return views;
		}

		public void setViews(int views) {
			this.views = views;
		}

		public int getBoardStatus() {
			return boardStatus;
		}

		public void setBoardStatus(int boardStatus) {
			this.boardStatus = boardStatus;
		}
		
		public String getHopeLatitude() {
			return hopeLatitude;
		}

		public void setHopeLatitude(String hopeLatitude) {
			this.hopeLatitude = hopeLatitude;
		}

		public String getHopeLongitude() {
			return hopeLongitude;
		}

		public void setHopeLongitude(String hopeLongitude) {
			this.hopeLongitude = hopeLongitude;
		}

		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
		

		public String getFileStreCours() {
			return fileStreCours;
		}

		public void setFileStreCours(String fileStreCours) {
			this.fileStreCours = fileStreCours;
		}
		
		

		public int getFileSn() {
			return fileSn;
		}

		public void setFileSn(int fileSn) {
			this.fileSn = fileSn;
		}

		@Override
		public String toString() {
			return "BoardVO [boardId=" + boardId + ", memId=" + memId + ", categoryId=" + categoryId + ", boardTitle="
					+ boardTitle + ", boardContents=" + boardContents + ", price=" + price + ", regiTime=" + regiTime
					+ ", updateTime=" + updateTime + ", regRange=" + regRange + ", intCnt=" + intCnt + ", chatCnt="
					+ chatCnt + ", views=" + views + ", boardStatus=" + boardStatus + ", hopeLatitude=" + hopeLatitude
					+ ", hopeLongitude=" + hopeLongitude + ", keyword=" + keyword + ", fileStreCours=" + fileStreCours
					+ ", fileSn=" + fileSn + ", start=" + start + ", end=" + end + "]";
		}

		
		


}
