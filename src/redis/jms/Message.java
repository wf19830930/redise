package redis.jms;

import java.io.Serializable;

/**定义消息类接收消息内容和设置消息的下标
 * @author wf
 *
 */
public class Message implements Serializable{
    private static final long serialVersionUID = 7792729L;
    private int id;
    private String content;
   
	public Message(int i, String string) {
		 this.id=i;
		 this.content=string;
	}
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}

