package org.bds.entity;

import javax.persistence.*;

/**
 * Created by bdomokos on 04/05/16.
 */
@Entity
@Table(name="simulations")
public class Simulation {
    private Long id;

    private String input;

    private String output;

    public Simulation() {
    }

    public Simulation(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="input")
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Column(name="output")
    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }


}
