import UserPathDeterminator.PathDeterminator;
import utils.InputScanner;

void main() {
    PathDeterminator path = new PathDeterminator();

    path.determineUserFinancialNeed();
    InputScanner.getScan().close();
}
