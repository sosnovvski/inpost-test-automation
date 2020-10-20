package api;

import java.io.IOException;
import java.util.List;

public interface IParcelLockerService {
	List<String> getParcelLockerInfo(int perPage) throws IOException;
}
