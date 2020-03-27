//Shane Heavey
//27-03-2020
//g00325970@gmit.ie
package ie.gmit.open;

import java.util.List;

public class ISPSubscriber extends Subsriber {

    private long freeUsage;

    public ISPSubscriber(Long subscriberId, String address, Long phoneNumber, int baseRate, long freeUsage) {
        super(subscriberId, address, phoneNumber, baseRate);
        this.freeUsage = freeUsage;
    }

    public double calculateBill() {
        List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory.getCurrentSessions(getSubscriberId());
        long totalData = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();
        long chargeableData = totalData - freeUsage;
        return chargeableData*getBaseRate()/100;
    }

    /**
     * @return the freeUsage
     */
    public long getFreeUsage() {
        return freeUsage;
    }
    /**
     * @param freeUsage the freeUsage to set
     */
    public void setFreeUsage(long freeUsage) {
        this.freeUsage = freeUsage;
    }

    
}