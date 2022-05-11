package psykeco.recipbe.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NativeQueries {

	public static final String QUERY_CHECK_TABLE ="SELECT count(1) from information_schema.tables where table_schema=? and table_name=?";
	
}
