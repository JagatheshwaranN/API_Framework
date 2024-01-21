package com.taf.pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "location",
        "phone",
        "courses"
})
public class Student {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("location")
    private String location;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("courses")
    private List<String> courses;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    @SuppressWarnings("unused")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    @SuppressWarnings("unused")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    @SuppressWarnings("unused")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("courses")
    public List<String> getCourses() {
        return courses;
    }

    @JsonProperty("courses")
    @SuppressWarnings("unused")
    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Student.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null)?"<null>":this.location));
        sb.append(',');
        sb.append("phone");
        sb.append('=');
        sb.append(((this.phone == null)?"<null>":this.phone));
        sb.append(',');
        sb.append("courses");
        sb.append('=');
        sb.append(((this.courses == null)?"<null>":this.courses));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}