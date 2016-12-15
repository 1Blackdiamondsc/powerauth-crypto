package io.getlime.security.repository.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Class representing a callback URL associated with given application.
 *
 * @author Petr Dvorak, petr@lime-company.eu
 */
@Entity(name = "pa_application_callback")
public class CallbackUrlEntity implements Serializable {

    private static final long serialVersionUID = 3372029113954119581L;

    @Id
    @Column(name = "id", updatable = false, length = 37)
    private String id;

    @Column(name = "application_id", updatable = false, nullable = false)
    private Long applicationId;

    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    @Column(name = "callback_url", nullable = false, updatable = false)
    private String callbackUrl;

    /**
     * Get the ID of an integration.
     * @return ID of an integration.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID of an integration.
     * @param id ID of an integration.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the application ID.
     * @return Application ID.
     */
    public Long getApplicationId() {
        return applicationId;
    }

    /**
     * Set application ID.
     * @param applicationId Application ID.
     */
    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * Get the name of an integration.
     * @return Name of an integration.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of an integration.
     * @param name Name of an integration.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get callback URL string.
     * @return Callback URL string.
     */
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * Set callback URL string.
     * @param callbackUrl Callback URL string.
     */
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}