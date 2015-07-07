package zttc.itat.model;

public class SystemContext {
	private static ThreadLocal<Integer> offset = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
	
	public static Integer getOffset() {
		return offset.get();
	}
	public static void setOffset(Integer _offset) {
		offset.set(_offset);
	}
	public static void removeOffset() {
		offset.remove();
	}
	
	public static Integer getPageSize() {
		return pageSize.get();
	}
	public static void setPageSize(Integer _size) {
		pageSize.set(_size);
	}
	public static void removePageSize() {
		pageSize.remove();
	}
	
}
