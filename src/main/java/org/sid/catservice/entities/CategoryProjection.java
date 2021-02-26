package org.sid.catservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "P2",types = Category.class)
public interface CategoryProjection {
    public Long getId();
    public String getName();
    public String getDescription();
}
