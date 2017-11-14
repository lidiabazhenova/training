package com.lidiabazhenova;


import java.util.Iterator;

import java.util.List;


public class SummaryInformation {
	private int id;
	List<Good> typeInfo;
	

	

	public SummaryInformation(int id, List<Good> typeInfo) {
		super();
		this.id = id;
		this.typeInfo = typeInfo;
	}



	public int getId() {
		return id;
	}

	

	 void printList(List<Good> list) {
        Iterator<Good> iterator = list.iterator();
        System.out.println(("===================================="));
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(("===================================="));

    }

}
