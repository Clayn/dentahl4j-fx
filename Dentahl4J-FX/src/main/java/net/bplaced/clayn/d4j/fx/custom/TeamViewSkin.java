package net.bplaced.clayn.d4j.fx.custom;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author Clayn <clayn_osmato@gmx.de>
 * @since 0.1
 */
public class TeamViewSkin extends SkinBase<TeamView>
{
    
    private final List<NinjaView> views = new ArrayList<>();
    
    TeamViewSkin(TeamView control)
    {
        super(control);
        control.setOnClear(new Runnable()
        {
            @Override
            public void run()
            {
                views.forEach((v) -> v.setNinja(null));
            }
        });
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.getStyleClass().add("background");
        for (int i = 0; i < 3; ++i)
        {
            ColumnConstraints col = new ColumnConstraints();
            RowConstraints row = new RowConstraints();
            grid.getColumnConstraints().add(col);
            grid.getRowConstraints().add(row);
        }
        for (int x = 0; x < 3; ++x)
        {
            for (int y = 0; y < 3; ++y)
            {
                NinjaView view = new NinjaView();
                view.setPrefSize(100, 50);
                view.setNinja(null);
                view.setXPosition(x);
                view.setYPosition(y);
                GridPane.setColumnIndex(view, x);
                GridPane.setRowIndex(view, y);
                grid.getChildren().add(view);
                views.add(view);
            }
        }
        getChildren().add(grid);
    }
    
}
