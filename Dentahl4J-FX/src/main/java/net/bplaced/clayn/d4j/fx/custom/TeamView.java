package net.bplaced.clayn.d4j.fx.custom;

import java.util.Optional;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

/**
 *
 * @author Clayn <clayn_osmato@gmx.de>
 * @since 0.1
 */
public class TeamView extends Control
{

    private final ObjectProperty<Runnable> onClear = new SimpleObjectProperty<>();

    Runnable getOnClear()
    {
        return onClear.get();
    }

    void setOnClear(Runnable value)
    {
        onClear.set(value);
    }

    ObjectProperty onClearProperty()
    {
        return onClear;
    }

    private final FXTeam team = new FXTeam();

    @Override
    protected Skin<?> createDefaultSkin()
    {
        return new TeamViewSkin(this);
    }

    public FXTeam getTeam()
    {
        return team;
    }

    public void clear()
    {
        Optional.ofNullable(onClear.get()).ifPresent(Runnable::run);
    }
}
