package com.company.project.core;

import java.util.List;

public class PageUtil {

	/**
	 * PageUtil
	 *
	 * @param list
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static <T> List<T> startPage(List<T> list, Integer pageNum, Integer pageSize) {
		if (list == null) {
			return null;
		}
		if (list.size() == 0) {
			return null;
		}

		Integer count = list.size(); // total records
		Integer pageCount = 0; //
		if (count % pageSize == 0) {
			pageCount = count / pageSize;
		} else {
			pageCount = count / pageSize + 1;
		}

		int fromIndex = 0;
		int toIndex = 0;

		if (pageNum > pageCount) {
			pageNum = pageCount;
		}

		if (pageNum < 1) {
			pageNum = 1;
		}

		if (!pageNum.equals(pageCount)) {
			fromIndex = (pageNum - 1) * pageSize;
			toIndex = fromIndex + pageSize;
		} else {
			fromIndex = (pageNum - 1) * pageSize;
			toIndex = count;
		}

		List<T> pageList = list.subList(fromIndex, toIndex);

		return pageList;
	}

}
