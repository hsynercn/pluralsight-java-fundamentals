package com.bergaz.fundamentals.core.collections.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Predicate;

public class PriorityHelpDesk {

    private static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {
        @Override
        public int compare(Enquiry o1, Enquiry o2) {
            return o1.getCategory().compareTo(o2.getCategory());
        }
    };

    private final Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);

    public void enquire(final Customer customer, final Category category) {
        enquiries.offer(new Enquiry(customer, category));
    }

    public void processAllEnquiries() {
        while(!enquiries.isEmpty()) {
            Enquiry enquiry = enquiries.remove();
            enquiry.getCustomer().reply("have you tries turning it off and on again?");
        }
    }

    public void processPrinterEnquiry() {
        String message = "Is it out of paper?";
        Predicate<Enquiry> predicate = enq -> enq.getCategory() == Category.PRINTER;
        processEnquiry(message, predicate);
    }

    public void processGeneralEnquiry() {
        String message = "Have you tried turning it off and on again?";
        Predicate<Enquiry> predicate = enq -> enq.getCategory() != Category.PRINTER;
        processEnquiry(message, predicate);
    }

    private void processEnquiry(String message, Predicate<Enquiry> predicate) {
        final Enquiry enquiry = enquiries.peek();
        if (enquiry != null && predicate.test(enquiry)) {
            enquiries.remove();
            enquiry.getCustomer().reply(message);
        } else {
            System.out.println("No problem");
        }
    }

    public static void main(String[] args) {
        PriorityHelpDesk priorityHelpDesk = new PriorityHelpDesk();

        priorityHelpDesk.enquire(Customer.JACK, Category.PHONE);
        priorityHelpDesk.enquire(Customer.JILL, Category.PRINTER);
        priorityHelpDesk.enquire(Customer.MARY, Category.COMPUTER);

        priorityHelpDesk.processAllEnquiries();
    }
}
