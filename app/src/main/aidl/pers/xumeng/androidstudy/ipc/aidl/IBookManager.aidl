// IBookManager.aidl
package pers.xumeng.androidstudy.ipc.aidl;

import pers.xumeng.androidstudy.ipc.aidl.Book;

interface IBookManager {

    List<Book> getBookList();

    void addBook(in Book book);

}