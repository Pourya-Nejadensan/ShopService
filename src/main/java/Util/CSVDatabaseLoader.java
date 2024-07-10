package Util;

import Model.Product;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVDatabaseLoader {
    public static List<Product> loadProductsFromCSV(String fileName) {
        List<Product> products = new ArrayList<>();

        try (InputStream inputStream = CSVDatabaseLoader.class.getClassLoader().getResourceAsStream(fileName);
             InputStreamReader streamReader = new InputStreamReader(inputStream);
             CSVReader csvReader = new CSVReader(streamReader)) {

            String[] values;
            csvReader.readNext(); // skip header
            while ((values = csvReader.readNext()) != null) {
                int id = Integer.parseInt(values[0]);
                String name = values[1];
                double price = Double.parseDouble(values[2]);
                int quantity = Integer.parseInt(values[3]);
                String description = values[4];

                Product product = new Product(id, name, price, quantity, description);
                products.add(product);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return products;
    }
}