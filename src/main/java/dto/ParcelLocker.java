package dto;

import java.util.List;

import dto.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParcelLocker {
	public List<Item> items;
	public int count;
	public int page;
	public int totalPages;
	public int perPage;
}
