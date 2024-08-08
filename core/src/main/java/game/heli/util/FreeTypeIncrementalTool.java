package game.heli.util;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeBitmapFontData;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.Array;
/***
 * 
 * 官方原文地址 https://github.com/libgdx/libgdx/blob/master/tests/gdx-tests/src/com/badlogic/gdx/tests/extensions/FreeTypeIncrementalTest.java
 * @author Admin
 *
 */
public class FreeTypeIncrementalTool{
	public static BitmapFont createBitmapFont(FileHandle ttfFile,FreeTypeFontParameter parameter) {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(ttfFile);
		parameter.incremental = true;
		parameter.characters = "howdY\u0000";
		FreeTypeBitmapFontData data = new FreeTypeBitmapFontData() {
			public int getWrapIndex (Array<Glyph> glyphs, int start) {
				return SimplifiedChinese.getWrapIndex(glyphs, start);
			}
		};
		data.xChars = new char[] {'动'};
		data.capChars = new char[] {'动'};
		BitmapFont font = generator.generateFont(parameter, data);
		return font;
	}
	static public class SimplifiedChinese {
		public static int getWrapIndex (Array<Glyph> glyphs, int start) {
			int i = start - 1;
			for (; i >= 1; i--) {
				int startChar = glyphs.get(i).id;
				if (!SimplifiedChinese.legalAtStart(startChar)) continue;
				int endChar = glyphs.get(i - 1).id;
				if (!SimplifiedChinese.legalAtEnd(endChar)) continue;
				// Don't wrap between ASCII chars.
				if (startChar < 127 && endChar < 127 && !Character.isWhitespace(startChar)) continue;
				return i;
			}
			return start;
		}

		static private boolean legalAtStart (int ch) {
			switch (ch) {
				case '!':
				case '%':
				case ')':
				case ',':
				case '.':
				case ':':
				case ';':
				case '>':
				case '?':
				case ']':
				case '}':
				case '¢':
				case '¨':
				case '°':
				case '·':
				case 'ˇ':
				case 'ˉ':
				case '―':
				case '‖':
				case '’':
				case '”':
				case '„':
				case '‟':
				case '†':
				case '‡':
				case '›':
				case '℃':
				case '∶':
				case '、':
				case '。':
				case '〃':
				case '〆':
				case '〈':
				case '《':
				case '「':
				case '『':
				case '〕':
				case '〗':
				case '〞':
				case '﹘':
				case '﹚':
				case '﹜':
				case '！':
				case '＂':
				case '％':
				case '＇':
				case '）':
				case '，':
				case '．':
				case '：':
				case '；':
				case '？':
				case '］':
				case '｀':
				case '｜':
				case '｝':
				case '～':
					return false;
			}
			return true;
		}

		static private boolean legalAtEnd (int ch) {
			switch (ch) {
				case '$':
				case '(':
				case '*':
				case ',':
				case '£':
				case '¥':
				case '·':
				case '‘':
				case '“':
				case '〈':
				case '《':
				case '「':
				case '『':
				case '【':
				case '〔':
				case '〖':
				case '〝':
				case '﹗':
				case '﹙':
				case '﹛':
				case '＄':
				case '（':
				case '．':
				case '［':
				case '｛':
				case '￡':
				case '￥':
					return false;
			}
			return true;
		}
	}
}
