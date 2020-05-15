package com.jsimao71.superheros.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.einnovator.jpa.model.EntityBase2;
import org.einnovator.util.model.ToStringCreator;

/**
 * A {@code Superhero}.
 *
 * @author Jorge Simao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Superhero extends EntityBase2<Long> {

    private String img;

    private String name;

    private Squad squad;

    private Boolean villain;

    private List<Superhero> friends;

    private String description;

    /**
     * Create instance of {@code Superhero}.
     */
    public Superhero() {
        super();
    }

    /**
     * Create instance of {@code Superhero}.
     *
     * @param obj a prototype
     */
    public Superhero(Object obj) {
        super(obj);
    }

    /**
     * Set value of property {@code img}.
     *
     * @param img the value of img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * Get value of property {@code img}.
     *
     * @return img the {@code img}
     */
    public String getImg() {
        return this.img;
    }

    /**
     * Set value of property {@code name}.
     *
     * @param name the value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get value of property {@code name}.
     *
     * @return name the {@code name}
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set value of property {@code squad}.
     *
     * @param squad the value of squad
     */
    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    /**
     * Get value of property {@code squad}.
     *
     * @return squad the {@code squad}
     */
    public Squad getSquad() {
        return this.squad;
    }

    /**
     * Set value of property {@code villain}.
     *
     * @param villain the value of villain
     */
    public void setVillain(Boolean villain) {
        this.villain = villain;
    }

    /**
     * Get value of property {@code villain}.
     *
     * @return villain the {@code villain}
     */
    public Boolean getVillain() {
        return this.villain;
    }

    /**
     * Set value of property {@code friends}.
     *
     * @param friends the value of friends
     */
    public void setFriends(List<Superhero> friends) {
        this.friends = friends;
    }

    /**
     * Get value of property {@code friends}.
     *
     * @return friends the {@code friends}
     */
    public List<Superhero> getFriends() {
        return this.friends;
    }

    /**
     * Set value of property {@code description}.
     *
     * @param description the value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get value of property {@code description}.
     *
     * @return description the {@code description}
     */
    public String getDescription() {
        return this.description;
    }

    public Superhero findFriend(String id) {
        if (id != null && friends != null) {
            for (Superhero friend : friends) {
                if (id.equals(friend.getUuid()) || id.equals(friend.getName())) {
                    return friend;
                }
            }
        }
        return null;
    }

    public void addFriend(Superhero friend) {
        if (this.friends == null) {
            this.friends = new ArrayList<>();
        }
        this.friends.add(friend);
    }

    public Superhero removeFriend(Superhero friend) {
        if (friend != null && friends != null) {
            for (int i = 0; i < friends.size(); i++) {
                Superhero friend0 = friends.get(i);
                if (friend0.getId().equals(friend.getId())) {
                    friends.remove(i);
                    return friend0;
                }
            }
        }
        return null;
    }

    @Override()
    public ToStringCreator toString0(ToStringCreator creator) {
        return super.toString0(creator);
    }

    @Override()
    public ToStringCreator toString1(ToStringCreator creator) {
        return super.toString1(creator)
                    .append("img", img)
                    .append("name", name)
                    .append("squad", squad)
                    .append("villain", villain)
                    .append("friends", friends)
                    .append("description", description);
    }

    @Override()
    public ToStringCreator toString2(ToStringCreator creator) {
        return super.toString2(creator);
    }
}
