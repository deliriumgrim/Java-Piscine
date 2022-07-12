package ex03;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private ListElement head;

    private ListElement tail;

    private Integer size;

    public TransactionsLinkedList() {
        size = 0;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        ListElement add = new ListElement();
        add.transaction = transaction;
        if (head == null) {
            head = add;
            tail = add;
            add.next = null;
            add.prev = null;
        } else {
            tail.next = add;
            add.prev = tail;
            tail = add;
        }
        size++;
    }

    @Override
    public void removeTransaction(UUID id) throws TransactionNotFoundException {

        ListElement tmp = null;

        if (head == null) {
            return ;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return ;
        }
        if (head.transaction.getIdentifier() == id) {
            head.next.prev = null;
            head = head.next;
            size--;
            return ;
        }
        tmp = head;
        while (tmp.next != null) {
            if (tmp.next.transaction.getIdentifier() == id) {
                if (tail == tmp.next) {
                    tail = tmp;
                } else {
                    tmp.next.next.prev = tmp;
                    tmp.next = tmp.next.next;
                }
                size--;
                return ;
            }
            tmp = tmp.next;
        }
        throw new TransactionNotFoundException("Transaction not found");
    }

    @Override
    public Transaction[] transformIntoArray() {

        ListElement tmp;
        Integer i = 0;

        if (size == 0) {
            return null;
        }
        Transaction[] array = new Transaction[size];
        tmp = head;
        while (i < size) {
            array[i] = tmp.transaction;
            tmp = tmp.next;
            i++;
        }
        return array;
    }

    static class ListElement {
        ListElement next;
        ListElement prev;
        Transaction transaction;
    }
}
