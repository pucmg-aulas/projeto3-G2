package com.lpm.controller;

import com.lpm.model.*;
import com.lpm.model.dao.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Veiculo> v = new VeiculoDAO().lerVeiculos("0");

        System.out.println(v.get(0).getPlaca());
    }
}
