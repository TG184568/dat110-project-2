package no.hvl.dat110.messages;

public class UnsubscribeMsg extends Message {

	// message sent from client to unsubscribe on a topic 

    private String topic;

    public UnsubscribeMsg(String user, String topic) {
        super(MessageType.UNSUBSCRIBE, user);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "UnsubscribeMsg [type=" + getType() + ", user=" + getUser() + ", topic=" + topic + "]";
    }

	// Complete the constructor, get/set-methods, and toString method
	// as described in the project text
	
}
