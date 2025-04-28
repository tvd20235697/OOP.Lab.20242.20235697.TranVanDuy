package hust.soict.hedspi.aims.media;

import java.util.Comparator;
public class MediaComparatorByCostTitle implements Comparator<Media> {
        @Override
        public int compare(Media m1, Media m2) {
            // So sánh theo chi phí, nếu bằng nhau thì so sánh theo tiêu đề
            int costComparison = Float.compare(m1.getCost(), m2.getCost());
            if (costComparison != 0) {
                return costComparison;
            }
            return m1.getTitle().compareTo(m2.getTitle()); // So sánh theo tiêu đề nếu chi phí bằng nhau
        }
}