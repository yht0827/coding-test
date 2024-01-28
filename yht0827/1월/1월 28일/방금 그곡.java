class Song {
	int time;
	String title;
	String lylics;
}

class solution {
	public String solution(String m, String[] musicinfos) {
		List<Song> list = new ArrayList<Song>();

		m = replaceString(m);

		for (int i = 0; i < musicinfos.length; i++) {
			String[] musicInfo = musicinfos[i].split(",");

			String[] start = musicInfo[0].split(":");
			String[] end = musicInfo[1].split(":");
			Song song = new Song();
			String title = musicInfo[2];
			String contents = replaceString(musicInfo[3]);

			song.title = title;

			int sH = Integer.parseInt(start[0]);
			int eH = Integer.parseInt(end[0]);
			int diff = (eH - sH) * 60;

			int sM = Integer.parseInt(start[1]);
			int eM = Integer.parseInt(end[1]);

			int minute = (eM + diff) - sM;
			song.time = minute;

			String total = "";

			int div = minute / contents.length();

			for (int j = 0; j < div; j++) {
				total += contents;
			}

			if (!"".equals(total) && minute % contents.length() != 0)
				total += contents.substring(0, minute % contents.length());

			if ("".equals(total))
				total = contents.substring(0, minute);

			song.lylics = total;

			list.add(song);
		}

		int maxTime = Integer.MIN_VALUE;
		String maxTitle = "";

		for (int i = 0; i < list.size(); i++) {
			Song song = list.get(i);

			if (song.lylics.contains(m)) {
				if (maxTime < song.time) {
					maxTitle = song.title;
					maxTime = Math.max(maxTime, song.time);
				}
			}

		}

		if (!"".equals(maxTitle))
			return maxTitle;

		return "(None)";
	}

	public String replaceString(String s) {
		return s.replaceAll("A#", "V")
			.replaceAll("C#", "W")
			.replaceAll("D#", "X")
			.replaceAll("F#", "Y")
			.replaceAll("G#", "Z");
	}
}
