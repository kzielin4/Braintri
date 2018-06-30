package pl.braintri.company.domain.entities;

import java.io.Serializable;

public interface SimpleIdEntity<ID extends Serializable> {
    ID getId();
}

