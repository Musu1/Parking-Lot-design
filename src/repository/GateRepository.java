package repository;

import exception.GateNotFoundException;
import models.Gate;

import java.util.HashMap;

public class GateRepository {
    HashMap<Integer, Gate> gateHashMap;

    public GateRepository() {
        this.gateHashMap = new HashMap<>();
    }

    public Gate get(int gateId) throws GateNotFoundException {
        Gate gate = gateHashMap.get(gateId);
        if(gate == null){
            throw new GateNotFoundException("Gate id not found , id = "+gateId);
        }
        return gate;
    }

    public Gate put(Gate gate){
        gateHashMap.put(gate.getId(),gate);
        return gate;
    }
}
