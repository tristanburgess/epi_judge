package count_bits_test

import (
	"fmt"
	"os"
	"path/filepath"
	"reflect"
	"testing"

	"github.com/stefantds/csvdecoder"

	. "go-epi-judge/epi/count_bits"
	utils "go-epi-judge/test_utils"
)

type solutionFunc = func(int32) int16

var solutions = []solutionFunc{
	CountBits, CountBitsCached,
}

func TestCountBits(t *testing.T) {
	testFileName := filepath.Join(cfg.TestDataFolder, "epi/count_bits.tsv")
	file, err := os.Open(testFileName)
	if err != nil {
		t.Fatalf("could not open file %s: %v", testFileName, err)
	}
	defer file.Close()

	type TestCase struct {
		X              int32
		ExpectedResult int16
		Details        string
	}

	parser, err := csvdecoder.NewWithConfig(file, csvdecoder.Config{Comma: '\t', IgnoreHeaders: true})
	if err != nil {
		t.Fatalf("could not parse file %s: %s", testFileName, err)
	}

	for i := 0; parser.Next(); i++ {
		tc := TestCase{}
		if err := parser.Scan(
			&tc.X,
			&tc.ExpectedResult,
			&tc.Details,
		); err != nil {
			t.Fatal(err)
		}

		for _, s := range solutions {
			var err error
			t.Run(fmt.Sprintf("Test Case %d %v", i, utils.GetFuncName(s)), func(t *testing.T) {
				if cfg.RunParallelTests {
					t.Parallel()
				}
				result := s(tc.X)
				if !reflect.DeepEqual(result, tc.ExpectedResult) {
					err = fmt.Errorf("\ngot:\n%v\nwant:\n%v\ntest case:\n%+v\n", result, tc.ExpectedResult, tc)
					t.Errorf(err.Error())
				}
			})
			if err != nil {
				t.FailNow()
			}
		}
	}
	if err = parser.Err(); err != nil {
		t.Fatalf("parsing error: %s", err)
	}
}
