package list_cyclic_right_shift_test

import (
	"fmt"
	"os"
	"path/filepath"
	"reflect"
	"testing"

	"github.com/stefantds/csvdecoder"

	"go-epi-judge/data_structures/list"
	. "go-epi-judge/epi/list_cyclic_right_shift"
	utils "go-epi-judge/test_utils"
)

type solutionFunc = func(*list.Node, int) *list.Node

var solutions = []solutionFunc{
	CyclicallyRightShiftList,
}

func TestCyclicallyRightShiftList(t *testing.T) {
	testFileName := filepath.Join(cfg.TestDataFolder, "epi/list_cyclic_right_shift.tsv")
	file, err := os.Open(testFileName)
	if err != nil {
		t.Fatalf("could not open file %s: %v", testFileName, err)
	}
	defer file.Close()

	type TestCase struct {
		L              list.NodeDecoder
		K              int
		ExpectedResult list.NodeDecoder
		Details        string
	}

	parser, err := csvdecoder.NewWithConfig(file, csvdecoder.Config{Comma: '\t', IgnoreHeaders: true})
	if err != nil {
		t.Fatalf("could not parse file %s: %s", testFileName, err)
	}

	for i := 0; parser.Next(); i++ {
		tc := TestCase{}
		if err := parser.Scan(
			&tc.L,
			&tc.K,
			&tc.ExpectedResult,
			&tc.Details,
		); err != nil {
			t.Fatal(err)
		}

		for _, s := range solutions {
			t.Run(fmt.Sprintf("Test Case %d %v", i, utils.GetFuncName(s)), func(t *testing.T) {
				if cfg.RunParallelTests {
					t.Parallel()
				}
				result := s(list.DeepCopy(tc.L.Value), tc.K)
				if !reflect.DeepEqual(result, tc.ExpectedResult.Value) {
					t.Errorf("\ngot:\n%v\nwant:\n%v\ntest case:\n%+v\n", result, tc.ExpectedResult.Value, tc)
				}
			})
		}
	}
	if err = parser.Err(); err != nil {
		t.Fatalf("parsing error: %s", err)
	}
}