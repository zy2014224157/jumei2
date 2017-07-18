package util;

public class Page {
	
	private  int pageSize;//ҳ���С���û����úõ�
	private int rowCount;//�ܼ�¼��    �����ݿ��ѯ
	private int pageCount;//��ҳ��
	private int beginRow;//�ӵڼ�����ʼ��ѯ
	private int currentPage;//��ǰҳ�ǵڼ�ҳ, �û�����
	
	private boolean hasprev;//�Ƿ�����һҳ      currentPage==1 false
	private boolean hasnext;//�Ƿ�����һҳ        currentPage == pageCount false

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {//��һ����pageCount=rowCount/pageSize  ���� rowCount/pageSize+1
		if(rowCount%pageSize==0)
		   pageCount=rowCount/pageSize;
		else
		   pageCount=rowCount/pageSize+1;
		
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getBeginRow() {//�ڶ���:beginRow=(currentPage-1)*pageSize
		beginRow=(currentPage-1)*pageSize;
		return beginRow;
	}
	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public boolean isHasprev() {//������ ��currentPage==1  false
		if(currentPage==1)
		     hasprev=false;
		else hasprev=true;
		
		return hasprev;
	}
	public void setHasprev(boolean hasprev) {
		this.hasprev = hasprev;
	}
	public boolean isHasnext() {//���Ĵ�:currentPage ==pageCount  false
		if(currentPage ==pageCount)
			hasnext=false;
		else hasnext=true;
		
		return hasnext;
	}
	public void setHasnext(boolean hasnext) {
		this.hasnext = hasnext;
	}
	

}
