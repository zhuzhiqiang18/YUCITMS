package com.yucitms.orm.bbs;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 论坛 帖子
 * @author qiangzi
 *
 */
public class Post implements java.io.Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -3021565121897728539L;
	private Integer id;
    private String title;
    private String content;
    private Date createTime;
    private String userName;
    private int respCount;
    private Type type;
    private Set<Response> responses = new HashSet<Response>();
    private boolean newresp;
    
    public Post() {
		super();
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public Set<Response> getResponses() {
        return responses;
    }

    public void setResponses(Set<Response> responses) {
        this.responses = responses;
    }

    public void addRespCount(int count) {
        respCount += count;
    }
    
    public void reduceRespCount(int count) {
        respCount -= count;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRespCount() {
        return respCount;
    }

    public void setRespCount(int respCount) {
        this.respCount = respCount;
    }

  
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isNewresp() {
		return newresp;
	}

	public void setNewresp(boolean newresp) {
		this.newresp = newresp;
	}

	public Post(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	
}
