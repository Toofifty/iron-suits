package me.toofifty.ironsuits.model;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseModel {

	final static Charset ENCODING = StandardCharsets.UTF_8;
	final static Pattern digits = Pattern
			.compile("\\[([\\d\\.-]+)\\, ([\\d\\.-]+)\\, ([\\d\\.-]+)\\]");
	final static Pattern name = Pattern
			.compile("\"(.*?)\": \\[([\\d\\.-]*?)\\, ([\\d\\.-]*?)\\]; (.*?)$");

	/**
	 * Grab model data from a file string.
	 * File should be in '.ism' format, check exo_helmet.ism
	 * in your text editor for the conventions.
	 * 
	 * @param file
	 * @return HashMap of model properties
	 */
	
	public static HashMap model(String file) {
		try {
			HashMap out = new HashMap();

			Path path;
			
			if (!file.contains(".ism")) {
				path = Paths.get(file + ".ism");
			} else {
				path = Paths.get(file);
			}
			// Grab a list of all lines from the file
			List<String> lines = Files.readAllLines(path, ENCODING);

			// Initialize 'current' (model piece) and 
			// 'bipedPiece' (what we want the armor to attach to)
			HashMap current = null;
			String bipedPiece = null;
			System.out.println("\nBeginning new object set for " + file);

			for (int i = 0; i < lines.size(); i++) {
				if (lines.get(i).endsWith("{")) {
					bipedPiece = lines.get(i).trim().replace(" {", "");
				} else if (lines.get(i).startsWith("!")) {
					Matcher m = Pattern.compile("!(.*?):\\[(.*?)\\,(.*?)\\]")
							.matcher(lines.get(i));
					while (m.find()) {
						out.put("textureX", Integer.parseInt(m.group(2)));
						out.put("textureY", Integer.parseInt(m.group(3)));
					}
				} else if (lines.get(i).trim().startsWith("\"")) {
					current = new HashMap();

					Matcher nameMatcher = name.matcher(lines.get(i));

					String name = null;
					int[] textureOffset = null;
					float[] position = null;
					int[] size = null;
					float[] rotation = new float[] { 0, 0, 0 };

					while (nameMatcher.find()) {
						name = nameMatcher.group(1);
						textureOffset = new int[] {
								Integer.parseInt(nameMatcher.group(2)),
								Integer.parseInt(nameMatcher.group(3)) };
						String[] trios = nameMatcher.group(4).split("; ");

						for (int j = 0; j < trios.length; j++) {
							//System.out.println(j + trios[j]);

							Matcher digitMatcher = digits.matcher(trios[j]);

							while (digitMatcher.find()) {
								switch (j) {
								case 0: // position
									position = new float[] {
											Float.parseFloat(digitMatcher.group(1)),
											Float.parseFloat(digitMatcher.group(2)),
											Float.parseFloat(digitMatcher.group(3)) };
								case 1: // size
									try {
										size = new int[] {
												Integer.parseInt(digitMatcher.group(1)),
												Integer.parseInt(digitMatcher.group(2)),
												Integer.parseInt(digitMatcher.group(3)) };
									} catch (Exception e) { }
								case 2: // rotation
									if (trios.length > 2) {
										rotation = new float[] {
												Float.parseFloat(digitMatcher.group(1)),
												Float.parseFloat(digitMatcher.group(2)),
												Float.parseFloat(digitMatcher.group(3)) };
									}
								}
							}
						}

					}

					if (position == null) {
						System.out.println("position is null for " + name);
					}
					current.put("textureOffset", textureOffset);
					current.put("position", position);
					current.put("size", size);
					current.put("rotation", rotation);
					current.put("bipedPiece", bipedPiece);
					out.put(name, current);
					current = null;

				} else if (lines.get(i).startsWith("}")) {
					bipedPiece = null;
				}
			}

			return out;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
