package net.bplaced.clayn.d4j.fx.custom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import net.bplaced.clayn.d4j.domain.Ninja;
import net.bplaced.clayn.d4j.domain.Team;

/**
 *
 * @author Clayn <clayn_osmato@gmx.de>
 * @since 0.1
 */
public class FXTeam extends Team
{

    private final ObservableMap<Integer, Ninja> positions = FXCollections.observableMap(
            super.getPositions());

    @Override
    public ObservableMap<Integer, Ninja> getPositions()
    {
        return positions;
    }

}
