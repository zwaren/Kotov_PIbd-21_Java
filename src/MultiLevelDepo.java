import java.util.ArrayList;

public class MultiLevelDepo {
    ArrayList<Depo<ITransport>> depoStages;
    private final int countPlaces = 15;

    public MultiLevelDepo(int countStages, int pictureWidth, int pictureHeight)
    {
        depoStages = new ArrayList<Depo<ITransport>>();
        for (int i = 0; i < countStages; ++i)
        {
            depoStages.add(new Depo<ITransport>(countPlaces, pictureWidth, pictureHeight));
        }
    }

    public Depo<ITransport> get(int index)
    {
        if (index > -1 && index < depoStages.size()) {
            return depoStages.get(index);
        }
        return null;
    }
}
