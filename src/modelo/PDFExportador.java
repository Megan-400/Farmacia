package modelo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.jfree.chart.JFreeChart;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PDFExportador
{

    public static void exportChartsToPDF(List<JFreeChart> charts, String filePath) throws IOException
    {
        // Validación de parámetros
        if (charts == null)
        {
            throw new IllegalArgumentException("La lista de gráficos no puede ser null");
        }
        if (charts.isEmpty())
        {
            throw new IllegalArgumentException("La lista de gráficos está vacía");
        }
        if (filePath == null || filePath.trim().isEmpty())
        {
            throw new IllegalArgumentException("La ruta del archivo no puede estar vacía");
        }

        try (PDDocument document = new PDDocument())
        {
            PDRectangle pageSize = new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth());
            float margin = 50;

            for (JFreeChart chart : charts)
            {
                if (chart == null)
                {
                    System.err.println("Advertencia: Se encontró un gráfico null en la lista");
                    continue;
                }

                PDPage page = new PDPage(pageSize);
                document.addPage(page);

                float availableWidth = pageSize.getWidth() - (2 * margin);
                float availableHeight = pageSize.getHeight() - (2 * margin);

                BufferedImage chartImage = createChartImage(chart, (int) availableWidth, (int) availableHeight);
                PDImageXObject pdfImage = LosslessFactory.createFromImage(document, chartImage);

                try (PDPageContentStream contentStream = new PDPageContentStream(document, page))
                {
                    contentStream.drawImage(pdfImage, margin, margin, availableWidth, availableHeight);
                }
            }

            document.save(new File(filePath));
        }
    }

    private static BufferedImage createChartImage(JFreeChart chart, int width, int height)
    {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        chart.draw(g2, new Rectangle2D.Double(0, 0, width, height));
        g2.dispose();
        return image;
    }
}
