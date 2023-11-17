package com.example.f23comp1011s1movies;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class SearchViewController {

    @FXML
    private ListView<Movie> listView;

    @FXML
    private Label msgLabel;

    @FXML
    private ImageView posterImageView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private HBox resultsBox;

    @FXML
    private Label resultsMsgLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private VBox selectedVBox;

    @FXML
    private VBox titlesVBox;

    @FXML
    private void initialize()
    {
        progressBar.setVisible(false);
        selectedVBox.setVisible(false);
        titlesVBox.setVisible(false);
        msgLabel.setVisible(false);

        listView.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldValue, movieSelected) ->{
                    if (movieSelected != null)
                    {
                        selectedVBox.setVisible(true);
                        try {
                            posterImageView.setImage(new Image(movieSelected.getPoster()));
                        } catch (IllegalArgumentException e)
                        {
                            posterImageView.setImage(new Image(Main.class.getResourceAsStream("images/default_poster.png")));
                        }
                    }
                    else
                    {
                        selectedVBox.setVisible(false);
                    }
                });
    }

    @FXML
    private void searchForMovies(ActionEvent event) throws IOException, InterruptedException {
        String movieName = searchTextField.getText().trim();
        ApiResponse apiResponse = APIUtility.callAPI(movieName);
        if (apiResponse.getMovies() != null)
        {
            titlesVBox.setVisible(true);
            listView.getItems().clear();
            listView.getItems().addAll(apiResponse.getMovies());
            resultsMsgLabel.setText("Showing " + listView.getItems().size() + " of " +apiResponse.getTotalResults());
        }
        else
        {
            titlesVBox.setVisible(false);
            msgLabel.setVisible(true);
            msgLabel.setText("Enter a movie title and click \"Search\"");
        }

    }
}
