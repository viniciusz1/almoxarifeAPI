package br.senai.sc.almoxarife.model.factory;

import java.util.ArrayList;

public class Builder {
        private ArrayList<String> builder = new ArrayList<String>();
        public void Append(String str) {
            builder.add(str);
        }
        public String Build() {
            return String.join(" ", builder);
        }
}
