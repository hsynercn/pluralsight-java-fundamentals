package com.bergaz.fundamentals.collections.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

public class HelpDesk {

    private final Queue<Enquiry> enquiries = new ArrayDeque<>();

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
        HelpDesk helpDesk = new HelpDesk();

        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);

        helpDesk.processPrinterEnquiry();
        helpDesk.processGeneralEnquiry();
        helpDesk.processPrinterEnquiry();
    }
}
