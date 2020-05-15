package com.jsimao71.superheros.xmodel;

import com.jsimao71.superheros.model.Squad;
import org.einnovator.util.model.ToStringCreator;

public class SuperheroFilter extends SuperheroOptions {

    private String q;

    private Squad squad;

    /**
     * Create instance of {@code SuperheroFilter}.
     */
    public SuperheroFilter() {
        super();
    }

    /**
     * Set value of property {@code q}.
     *
     * @param q the value of q
     */
    public void setQ(String q) {
        this.q = q;
    }

    /**
     * Get value of property {@code q}.
     *
     * @return q the {@code q}
     */
    public String getQ() {
        return this.q;
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
     * Set value of property {@code q}.
     *
     * @param q the value of q
     * @return {@code this}
     */
    public SuperheroFilter withQ(String q) {
        this.q = q;
        return this;
    }

    /**
     * Set value of property {@code squad}.
     *
     * @param squad the value of squad
     * @return {@code this}
     */
    public SuperheroFilter withSquad(Squad squad) {
        this.squad = squad;
        return this;
    }

    @Override()
    public ToStringCreator toString1(ToStringCreator creator) {
        return super.toString1(creator)
                    .append("q", q)
                    .append("squad", squad);
    }
}
