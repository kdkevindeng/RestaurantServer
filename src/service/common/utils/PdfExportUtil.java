package service.common.utils;


public class PdfExportUtil {/*
	public static void getPDF(Map paras) throws DocumentException,
			MalformedURLException, IOException {
		BaseFont bfChinese = BaseFont.createFont("STSongStd-Light",
				"UniGB-UCS2-H", false);

		Font FontChinese = new Font(bfChinese, 14, Font.NORMAL);
		Font fontfpdm = new Font(bfChinese, 14, Font.NORMAL, new BaseColor(83,
				12, 20));

		Document document = new Document(new Rectangle(842, 570), 0, 0, 0, 0);
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream("C:\\Users\\Administrator\\Desktop\\"
						+ paras.get("fpdm").toString() + "_"
						+ paras.get("fphm").toString() + ".pdf"));

		document.open();

		Image jpg = Image
				.getInstance("C:\\Users\\Administrator\\Desktop\\a.jpg");
		// ������ʾ��ʽ

		jpg.setAlignment(Image.UNDERLYING);

		// ���þ��λ��

		jpg.setAbsolutePosition(0, 0);

		// ����ͼƬ��С595,842ΪA4ֽ�Ĵ�С

		jpg.scaleAbsolute(842, 570);

		document.add(jpg);

		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));

		Paragraph row1 = new Paragraph(paras.get("fpdm").toString(), fontfpdm);
		row1.setFirstLineIndent(650);
		document.add(row1);

		Paragraph row2 = new Paragraph(paras.get("fphm").toString(), fontfpdm);
		row2.setFirstLineIndent(650);
		document.add(row2);

		Paragraph row3 = new Paragraph(
				"              "
						+ paras.get("kprq").toString()
						+ "                                           ˰���ش�                                                      "
						+ paras.get("fphm").toString(), FontChinese);
		row3.setFirstLineIndent(150);
		document.add(row3);

		document.add(new Paragraph("\n"));

		Paragraph row4 = new Paragraph("������         "
				+ paras.get("fkfmc").toString()
				+ "                    ����ͨ��Ʊ��������", FontChinese);
		row4.setFirstLineIndent(150);
		document.add(row4);

		Paragraph row5 = new Paragraph("�տ��Ƽ���ַ���绰         "
				+ paras.get("skfmc").toString() + "     �տʶ��Ż�֤������ "
				+ paras.get("nsrsbh").toString(), FontChinese);
		row5.setFirstLineIndent(150);
		document.add(row5);

		document.add(new Paragraph("\n"));

		Paragraph row6 = new Paragraph(
				"ƷĿ�����                                                                                      ��ע",
				FontChinese);
		row6.setFirstLineIndent(170);
		document.add(row6);

		Paragraph row7 = new Paragraph(paras.get("hwmc").toString()
				+ "          " + paras.get("zje").toString() + "    "
				+ paras.get("ggxh").toString() + "    "
				+ paras.get("dw").toString() + "         "
				+ paras.get("sl").toString() + "         "
				+ paras.get("zje").toString(), FontChinese);
		row7.setFirstLineIndent(150);
		document.add(row7);

		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));

		Paragraph row8 = new Paragraph("��λ����", FontChinese);
		row8.setFirstLineIndent(650);
		document.add(row8);

		document.add(new Paragraph("\n"));

		Paragraph row9 = new Paragraph(
				"�ϼ�����ң���д�� @"
						+ paras.get("zje").toString()
						+ "                                                   Сд                                         ��"
						+ paras.get("zje").toString(), FontChinese);
		row9.setFirstLineIndent(150);
		document.add(row9);

		Paragraph row10 = new Paragraph(
				"˰���д�� @"
						+ paras.get("zse").toString()
						+ "                                                                  ��˰ƾ֤��         "
						+ paras.get("wspzh").toString(), FontChinese);
		row10.setFirstLineIndent(150);
		document.add(row10);

		Paragraph row11 = new Paragraph(
				"˰����                                                                  ��Ʊ��                                       "
						+ paras.get("kpr").toString(), FontChinese);
		row11.setFirstLineIndent(150);
		document.add(row11);
		document.close();

	}
*/}
